export interface Typologie {
  id: string;
  title: string;
  type: string;
  requiresSignature: boolean;
  requiresInitials: boolean;
  emailAdresses: Array<string>
}
