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
              <Button size="md" variant="outline" :startIcon="TrashIcon"> Supprimer </Button>
            </div>
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
  <TypologieModal v-if="isModalOpen" @close="isModalOpen = false">
    <p>Contenu personnalisé sans utiliser de slots nommés</p>
  </TypologieModal>
</template>

<script lang="ts" setup>
  import {
    DocsIcon,
    PlusIcon, RefreshIcon,
    TrashIcon
  } from '@/icons'
  import Button from '@/components/ui/Button.vue'
  import { onMounted, ref } from "vue";
  import type { Typologie } from "@/components/tables/typologie-table/Typologie.ts";
  import TypologieModal from "@/components/tables/typologie-table/TypologieModal.vue";

  const typologies = ref<Typologie[]>([]);
  const isModalOpen = ref(false)

  const openModal = () => {
    isModalOpen.value = true
  }

  onMounted(async () => {
    const res = await fetch("/api/typologie");
    typologies.value = await res.json() as Typologie[];
  })

</script>

<style scoped>
/* Add any additional styles here if needed */
</style>
