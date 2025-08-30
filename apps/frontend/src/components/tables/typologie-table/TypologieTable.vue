<template>

  <Button size="sm" variant="primary" :startIcon="PlusIcon" @click="openModal"> Ajouter </Button>

  <div
    class="overflow-hidden rounded-xl border border-gray-200 bg-white dark:border-gray-800 dark:bg-white/[0.03]"
  >
    <div class="max-w-full overflow-x-auto custom-scrollbar">
      <table class="min-w-full">
        <thead>
        <tr class="border-b border-gray-200 dark:border-gray-700">
          <th class="px-5 py-3 text-left w-3/11 sm:px-6">
            <p class="font-medium text-gray-500 text-theme-xs dark:text-gray-400">Typologie</p>
          </th>
          <th class="px-5 py-3 text-left w-2/11 sm:px-6">
            <p class="font-medium text-gray-500 text-theme-xs dark:text-gray-400">Signature obligatoire</p>
          </th>
          <th class="px-5 py-3 text-left w-2/11 sm:px-6">
            <p class="font-medium text-gray-500 text-theme-xs dark:text-gray-400">Paraphe obligatoire</p>
          </th>
          <th class="px-5 py-3 text-left w-2/11 sm:px-6">
            <p class="font-medium text-gray-500 text-theme-xs dark:text-gray-400">Adresses emails</p>
          </th>
          <th class="px-5 py-3 text-left w-2/11 sm:px-6">
            <p class="font-medium text-gray-500 text-theme-xs dark:text-gray-400">Actions</p>
          </th>
        </tr>
        </thead>
        <tbody class="divide-y divide-gray-200 dark:divide-gray-700">
        <tr
          v-for="(typologie, index) in typologies"
          :key="index"
          class="border-t border-gray-100 dark:border-gray-800"
        >
          <td class="px-5 py-4 sm:px-6">
            <div class="flex items-center gap-3">
              <div class="w-10 h-10 overflow-hidden rounded-full">
                <DocsIcon></DocsIcon>
              </div>
              <div>
                  <span class="block font-medium text-gray-800 text-theme-sm dark:text-white/90">
                    {{ typologie.title }}
                  </span>
                <span class="block text-gray-500 text-theme-xs dark:text-gray-400">
                    {{ typologie.type }}
                  </span>
              </div>
            </div>
          </td>
          <td class="px-5 py-4 sm:px-6">
               <span v-if="typologie.requiresSignature"
                     class="bg-success-50 text-success-700 dark:bg-success-500/15 dark:text-success-500"
               >
                Oui
              </span>
            <span v-else
                  class="rounded-full bg-warning-50 text-warning-700 dark:bg-warning-500/15 dark:text-warning-500">
                Non
              </span>
          </td>
          <td class="px-5 py-4 sm:px-6">
              <span v-if="typologie.requiresInitials"
                class="bg-success-50 text-success-700 dark:bg-success-500/15 dark:text-success-500"
              >
                Oui
              </span>
              <span v-else
                class="rounded-full bg-warning-50 text-warning-700 dark:bg-warning-500/15 dark:text-warning-500">
                Non
              </span>
          </td>
          <td class="px-5 py-4 sm:px-6">
            <p class="text-gray-500 text-theme-sm dark:text-gray-400">{{ typologie.emailAdresses }}</p>
          </td>
          <td class="px-5 py-4 sm:px-6">
            <div class="flex items-center gap-5">
              <Button size="sm" variant="primary" :startIcon="RefreshIcon"> Modifier </Button>
              <Button size="md" variant="outline" :startIcon="TrashIcon" @click="deleteTypologie(typologie.id)"> Supprimer </Button>
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
  <Modal v-if="isModalOpen" @close="isModalOpen = false">
    <template #body>
      <div
        class="no-scrollbar relative w-full max-w-[700px] overflow-y-auto rounded-3xl bg-white p-4 dark:bg-gray-900 lg:p-11"
      >
        <button
          @click="isModalOpen = false"
          class="transition-color absolute right-5 top-5 z-999 flex h-11 w-11 items-center justify-center rounded-full bg-gray-100 text-gray-400 hover:bg-gray-200 hover:text-gray-600 dark:bg-gray-700 dark:bg-white/[0.05] dark:text-gray-400 dark:hover:bg-white/[0.07] dark:hover:text-gray-300"
        >
          <svg
            class="fill-current"
            width="24"
            height="24"
            viewBox="0 0 24 24"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
          >
            <path
              fill-rule="evenodd"
              clip-rule="evenodd"
              d="M6.04289 16.5418C5.65237 16.9323 5.65237 17.5655 6.04289 17.956C6.43342 18.3465 7.06658 18.3465 7.45711 17.956L11.9987 13.4144L16.5408 17.9565C16.9313 18.347 17.5645 18.347 17.955 17.9565C18.3455 17.566 18.3455 16.9328 17.955 16.5423L13.4129 12.0002L17.955 7.45808C18.3455 7.06756 18.3455 6.43439 17.955 6.04387C17.5645 5.65335 16.9313 5.65335 16.5408 6.04387L11.9987 10.586L7.45711 6.04439C7.06658 5.65386 6.43342 5.65386 6.04289 6.04439C5.65237 6.43491 5.65237 7.06808 6.04289 7.4586L10.5845 12.0002L6.04289 16.5418Z"
              fill=""
            />
          </svg>
        </button>
        <div class="px-2 pr-14">
          <h4 class="mb-2 text-2xl font-semibold text-gray-800 dark:text-white/90">
            Ajouter une typologie
          </h4>
          <p class="mb-6 text-sm text-gray-500 dark:text-gray-400 lg:mb-7">
            Ajouter une typologie avant de lui associer un utilisateur.
          </p>
        </div>
        <form class="flex flex-col">
          <div class="custom-scrollbar overflow-y-auto p-2">
            <div class="mt-2">

              <div class="grid grid-cols-1 gap-x-6 gap-y-5 lg:grid-cols-2">
                <div class="col-span-2 lg:col-span-1">
                  <label
                    class="mb-1.5 block text-sm font-medium text-gray-700 dark:text-gray-400"
                  >
                    Titre
                  </label>
                  <input
                    type="text"
                    v-model="formData.title"
                    class="dark:bg-dark-900 h-11 w-full rounded-lg border border-gray-300 bg-transparent bg-none px-4 py-2.5 text-sm text-gray-800 shadow-theme-xs placeholder:text-gray-400 focus:border-brand-300 focus:outline-hidden focus:ring-3 focus:ring-brand-500/10 dark:border-gray-700 dark:bg-gray-900 dark:text-white/90 dark:placeholder:text-white/30 dark:focus:border-brand-800"
                  />
                </div>

                <div class="col-span-2 lg:col-span-1">
                  <label
                    class="mb-1.5 block text-sm font-medium text-gray-700 dark:text-gray-400"
                  >
                    Type
                  </label>
                  <input
                    type="text"
                    v-model="formData.type"
                    class="dark:bg-dark-900 h-11 w-full appearance-none rounded-lg border border-gray-300 bg-transparent bg-none px-4 py-2.5 text-sm text-gray-800 shadow-theme-xs placeholder:text-gray-400 focus:border-brand-300 focus:outline-hidden focus:ring-3 focus:ring-brand-500/10 dark:border-gray-700 dark:bg-gray-900 dark:text-white/90 dark:placeholder:text-white/30 dark:focus:border-brand-800"
                  />
                </div>

                <div class="col-span-2 lg:col-span-1">
                  <label
                    for="checkboxLabelOne"
                    class="flex items-center text-sm font-medium text-gray-700 cursor-pointer select-none dark:text-gray-400"
                  >
                    <div class="relative">
                      <input type="checkbox" id="checkboxLabelOne" v-model="formData.requiresSignature" class="sr-only" />
                      <div
                        :class="
                formData.requiresSignature
                  ? 'border-brand-500 bg-brand-500'
                  : 'bg-transparent border-gray-300 dark:border-gray-700'
              "
                        class="mr-3 flex h-5 w-5 items-center justify-center rounded-md border-[1.25px] hover:border-brand-500 dark:hover:border-brand-500"
                      >
              <span :class="formData.requiresSignature ? '' : 'opacity-0'">
                <svg
                  width="14"
                  height="14"
                  viewBox="0 0 14 14"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M11.6666 3.5L5.24992 9.91667L2.33325 7"
                    stroke="white"
                    stroke-width="1.94437"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
              </span>
                      </div>
                    </div>
                    Signature obligatoire
                  </label>
                </div>

                <div class="col-span-2 lg:col-span-1">
                  <label
                    for="checkboxLabelTwo"
                    class="flex items-center text-sm font-medium text-gray-700 cursor-pointer select-none dark:text-gray-400"
                  >
                    <div class="relative">
                      <input type="checkbox" id="checkboxLabelTwo" v-model="formData.requiresInitials" class="sr-only" />
                      <div
                        :class="
                formData.requiresInitials
                  ? 'border-brand-500 bg-brand-500'
                  : 'bg-transparent border-gray-300 dark:border-gray-700'
              "
                        class="mr-3 flex h-5 w-5 items-center justify-center rounded-md border-[1.25px] hover:border-brand-500 dark:hover:border-brand-500"
                      >
              <span :class="formData.requiresInitials ? '' : 'opacity-0'">
                <svg
                  width="14"
                  height="14"
                  viewBox="0 0 14 14"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path
                    d="M11.6666 3.5L5.24992 9.91667L2.33325 7"
                    stroke="white"
                    stroke-width="1.94437"
                    stroke-linecap="round"
                    stroke-linejoin="round"
                  />
                </svg>
              </span>
                      </div>
                    </div>
                    Paraphe obligatoire
                  </label>
                </div>

              </div>

              <div class="col-span-2 lg:col-span-1">
                <label
                  class="mt-5 mb-1.5 block text-sm font-medium text-gray-700 dark:text-gray-400"
                >
                  Adresses emails
                </label>
                <input
                  type="text"
                  v-model="formData.emails"
                  class="dark:bg-dark-900 h-11 w-full appearance-none rounded-lg border border-gray-300 bg-transparent bg-none px-4 py-2.5 text-sm text-gray-800 shadow-theme-xs placeholder:text-gray-400 focus:border-brand-300 focus:outline-hidden focus:ring-3 focus:ring-brand-500/10 dark:border-gray-700 dark:bg-gray-900 dark:text-white/90 dark:placeholder:text-white/30 dark:focus:border-brand-800"
                />
              </div>
            </div>
          </div>
          <div class="flex items-center gap-3 px-2 mt-6 lg:justify-end">
            <button
              @click="saveTypologie"
              type="button"
              class="flex w-full justify-center rounded-lg bg-brand-500 px-4 py-2.5 text-sm font-medium text-white hover:bg-brand-600 sm:w-auto"
            >
              Enregistrer
            </button>
            <button
              @click="isModalOpen = false"
              type="button"
              class="flex w-full justify-center rounded-lg border border-gray-300 bg-white px-4 py-2.5 text-sm font-medium text-gray-700 hover:bg-gray-50 dark:border-gray-700 dark:bg-gray-800 dark:text-gray-400 dark:hover:bg-white/[0.03] sm:w-auto"
            >
              Fermer
            </button>
          </div>
        </form>
      </div>
    </template>
  </Modal>
</template>

<script lang="ts" setup>
  import {
    DocsIcon,
    PlusIcon, RefreshIcon,
    TrashIcon
  } from '@/icons'
  import Button from '@/components/ui/Button.vue'
  import { onMounted, reactive, ref } from "vue";
  import type { Typologie } from "@/components/tables/typologie-table/Typologie.ts";
  import Modal from "@/components/profile/Modal.vue";

  const typologies = ref<Typologie[]>([]);
  const isModalOpen = ref(false)

  const openModal = () => {
    isModalOpen.value = true
  }

  const formData = reactive({
    title: '',
    type: 'GENERAL',
    requiresSignature: false,
    requiresInitials: false,
    emails: '',
  })

  const saveTypologie = async () => {
    const response = await fetch('/api/typologie', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        title: formData.title,
        type: formData.type,
        requiresSignature: formData.requiresSignature,
        requiresInitials: formData.requiresInitials,
        emailAdresses: formData.emails.split(",").map((e) => e.trim()),
      })
    });
    if (!response.ok) {
      throw new Error(`Erreur HTTP: ${response.status}`);
    }
    isModalOpen.value = false;
  }

  const deleteTypologie = async (id: string) => {
    const res = await fetch("/api/typologie/" + id, {
      method: "DELETE"
    });
    if (res.status === 200) {
      typologies.value = typologies.value.filter((typologie) =>
        typologie.id !== id
      )
    }
  }

  onMounted(async () => {
    const res = await fetch("/api/typologie");
    typologies.value = await res.json() as Typologie[];
  })

</script>

<style scoped>
/* Add any additional styles here if needed */
</style>
