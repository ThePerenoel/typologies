<template>
  <AdminLayout>
    <div class="space-y-5 sm:space-y-6">
      <ComponentCard title="Liste des typologies">
        <TypologieTable />
      </ComponentCard>
    </div>
  </AdminLayout>
</template>

<script lang="ts" setup>
import AdminLayout from "@/components/layout/AdminLayout.vue";
import ComponentCard from "@/components/common/ComponentCard.vue";
import TypologieTable from '@/components/tables/typologie-table/TypologieTable.vue'
</script>
