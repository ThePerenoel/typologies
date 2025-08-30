import type { Typologie } from "@/components/tables/typologie-table/Typologie.ts";

export class User {
  id: number
  firstName: string
  lastName: string
  typologies: Typologie[]

  constructor(id: number, firstName: string, lastName: string, typologies: Typologie[] = []) {
    this.id = id
    this.firstName = firstName
    this.lastName = lastName
    this.typologies = typologies
  }
}
