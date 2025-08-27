<script setup lang="ts">
  import { reactive } from "vue";
  import Button from "@/components/ui/Button.vue";

  const emit = defineEmits<{
    (e: 'close'): void
  }>()

  const close = () => {
    emit('close')
  }

  const options = [
    { value: 'GENERAL', label: 'Général' },
    { value: 'CUSTOM', label: 'Personnalisé' },
  ]

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
  }
</script>

<template>
  <div class="modal-backdrop">
    <div class="modal">
      <header class="modal-header">
        <slot name="header">Ajouter une typologie</slot>
        <button @click="close">x</button>
      </header>
      <section class="modal-body">
        <div class="mb-3">
          <label class="mb-1.5 block text-sm font-medium text-gray-700 dark:text-gray-400">
            Titre
          </label>
          <input
            type="text"
            v-model="formData.title"
            class="dark:bg-dark-900 h-11 w-full rounded-lg border border-gray-300 bg-transparent px-4 py-2.5 text-sm text-gray-800 shadow-theme-xs placeholder:text-gray-400 focus:border-brand-300 focus:outline-hidden focus:ring-3 focus:ring-brand-500/10 dark:border-gray-700 dark:bg-gray-900 dark:text-white/90 dark:placeholder:text-white/30 dark:focus:border-brand-800"
          />
        </div>
        <div class="mb-4">
          <label class="mb-1.5 block text-sm font-medium text-gray-700 dark:text-gray-400">
            Type
          </label>
          <select
            v-model="formData.type"
            class="dark:bg-dark-900 h-11 w-full appearance-none rounded-lg border border-gray-300 bg-transparent bg-none px-4 py-2.5 pr-11 text-sm text-gray-800 shadow-theme-xs placeholder:text-gray-400 focus:border-brand-300 focus:outline-hidden focus:ring-3 focus:ring-brand-500/10 dark:border-gray-700 dark:bg-gray-900 dark:text-white/90 dark:placeholder:text-white/30 dark:focus:border-brand-800"
            :class="{ 'text-gray-800 dark:text-white/90': formData.type }"
          >
            <option v-for="(value, index) in options" :value="value.value" :key="index" class="text-gray-700 dark:bg-gray-900 dark:text-gray-400">
              {{ value.label }}
            </option>
          </select>
        </div>
        <div class="mb-3">
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
        <div class="mb-3">
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
        <div class="mb-3">
          <label class="mb-1.5 block text-sm font-medium text-gray-700 dark:text-gray-400">
            Adresses emails
          </label>
          <input
            type="text"
            v-model="formData.emails"
            class="dark:bg-dark-900 h-11 w-full rounded-lg border border-gray-300 bg-transparent px-4 py-2.5 text-sm text-gray-800 shadow-theme-xs placeholder:text-gray-400 focus:border-brand-300 focus:outline-hidden focus:ring-3 focus:ring-brand-500/10 dark:border-gray-700 dark:bg-gray-900 dark:text-white/90 dark:placeholder:text-white/30 dark:focus:border-brand-800"
          />
        </div>
      </section>
      <footer class="modal-footer">
        <Button class="md-9" @click="saveTypologie" size="sm" variant="primary"> Sauvegarder </Button>
        <Button size="sm"  @click="close" variant="outline"> Fermer </Button>
      </footer>
    </div>
  </div>
</template>

<style scoped>
.modal-backdrop {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  background-color: rgba(0, 0, 0, 0.6);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000;
  padding: 20px;
  backdrop-filter: blur(4px);
  animation: fadeIn 0.2s ease-out;
}

.modal {
  background: white;
  border-radius: 12px;
  box-shadow: 0 25px 50px -12px rgba(0, 0, 0, 0.25),
  0 0 0 1px rgba(255, 255, 255, 0.05);
  max-width: 500px;
  width: 100%;
  max-height: 90vh;
  overflow: hidden;
  display: flex;
  flex-direction: column;
  animation: modalIn 0.3s cubic-bezier(0.34, 1.56, 0.64, 1);
}

.modal-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 24px 24px 24px;
  border-bottom: 1px solid #e5e7eb;
  margin-bottom: 24px;
  position: relative;
}

.modal-title {
  font-size: 1.5rem;
  font-weight: 600;
  color: #1f2937;
  line-height: 1.4;
}

.close-button {
  position: absolute;
  top: 20px;
  right: 20px;
  background: none;
  border: none;
  cursor: pointer;
  padding: 8px;
  border-radius: 50%;
  color: #6b7280;
  transition: all 0.2s ease;
  display: flex;
  align-items: center;
  justify-content: center;
}

.close-button:hover {
  background-color: #f3f4f6;
  color: #374151;
  transform: scale(1.05);
}

.close-button:active {
  transform: scale(0.95);
}

.modal-body {
  padding: 0 24px;
  overflow-y: auto;
  flex: 1;
  color: #4b5563;
  line-height: 1.6;
}

.modal-footer {
  text-align: right;
  padding: 24px;
  border-top: 1px solid #e5e7eb;
  margin-top: 24px;
}

.modal-footer button {
  padding: 10px;
}


/* Animations */
@keyframes fadeIn {
  from { opacity: 0; }
  to { opacity: 1; }
}

@keyframes modalIn {
  from {
    opacity: 0;
    transform: scale(0.9) translateY(-20px);
  }
  to {
    opacity: 1;
    transform: scale(1) translateY(0);
  }
}

/* Responsive */
@media (max-width: 768px) {
  .modal-backdrop {
    padding: 16px;
  }

  .modal {
    max-height: 95vh;
    border-radius: 8px;
  }

  .modal-header,
  .modal-body,
  .modal-footer {
    padding-left: 16px;
    padding-right: 16px;
  }

  .modal-header {
    padding-bottom: 0;
    margin-bottom: 16px;
  }

  .modal-footer {
    padding-top: 16px;
    margin-top: 16px;
  }
}
</style>
