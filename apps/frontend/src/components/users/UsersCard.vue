<template>
  <div>
    <div class="p-5 mb-6 border border-gray-200 rounded-2xl dark:border-gray-800 lg:p-6">
      <div class="flex flex-col gap-6 lg:flex-row lg:items-start lg:justify-between">
        <div>
          <h4 class="text-lg font-semibold text-gray-800 dark:text-white/90 lg:mb-6">
            Personal Information
          </h4>

          <div class="grid grid-cols-1 gap-4 lg:grid-cols-2 lg:gap-7 2xl:gap-x-32">
            <div>
              <p class="mb-2 text-xs leading-normal text-gray-500 dark:text-gray-400">First Name</p>
              <p class="text-sm font-medium text-gray-800 dark:text-white/90">{{props.user.firstName}}</p>
            </div>

            <div>
              <p class="mb-2 text-xs leading-normal text-gray-500 dark:text-gray-400">Last Name</p>
              <p class="text-sm font-medium text-gray-800 dark:text-white/90">{{props.user.lastName}}</p>
            </div>

            <div>
              <p class="mb-2 text-xs leading-normal text-gray-500 dark:text-gray-400">Typologies</p>
              <p v-for="typologie in props.user.typologies" :key="typologie.id" class="text-sm font-medium text-gray-800 dark:text-white/90">
                {{typologie.title}}
              </p>

              <select
                v-model="selectedTypologie"
                class="dark:bg-dark-900 h-11 w-full appearance-none rounded-lg border border-gray-300 bg-transparent bg-none px-4 py-2.5 pr-11 text-sm text-gray-800 shadow-theme-xs placeholder:text-gray-400 focus:border-brand-300 focus:outline-hidden focus:ring-3 focus:ring-brand-500/10 dark:border-gray-700 dark:bg-gray-900 dark:text-white/90 dark:placeholder:text-white/30 dark:focus:border-brand-800"
                :class="{ 'text-gray-800 dark:text-white/90': selectedTypologie }"
              >
                <option value="" disabled selected>Select Option</option>
                <option v-for="typologie in typologies" :key="typologie.id" value="marketing">{{typologie.title}}</option>
              </select>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import type { User } from "@/views/Users/User.ts";
import type { Typologie } from "@/components/tables/typologie-table/Typologie.ts";
import { ref } from "vue";

interface Props {
  user: User,
  typologies: Typologie[]
}

const selectedTypologie = ref<string>("");

const props = defineProps<Props>()

</script>
