<template>
  <admin-layout>
    <PageBreadcrumb :pageTitle="currentPageTitle" />

    <div
      class="rounded-2xl border border-gray-200 bg-white p-5 dark:border-gray-800 dark:bg-white/[0.03] lg:p-6"
    >
      <h3 class="mb-5 text-lg font-semibold text-gray-800 dark:text-white/90 lg:mb-7">Users</h3>
      <users-card v-for="user in users" :key="user.id" :user="user" :typologies="typologies"/>
    </div>
  </admin-layout>
</template>

<script lang="ts" setup>
import AdminLayout from '../../components/layout/AdminLayout.vue'
import PageBreadcrumb from '@/components/common/PageBreadcrumb.vue'
import { onMounted, ref } from 'vue'
import UsersCard from "@/components/users/UsersCard.vue";
import type { User } from "@/views/Users/User.ts";
import type { Typologie } from "@/components/tables/typologie-table/Typologie.ts";
const currentPageTitle = ref('Users')

const users = ref<User[]>([]);
const typologies = ref<Typologie[]>([]);

onMounted(async () => {
  const res = await fetch("/api/users");
  users.value = await res.json() as User[];
  const res1 = await fetch("/api/typologie");
  typologies.value = await res1.json() as Typologie[];
})

</script>
