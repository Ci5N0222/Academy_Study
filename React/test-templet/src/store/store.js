import { create } from 'zustand';

export const useMemberStore = create(set => ({
  sign: false,
  setSign: param => set({ sign: param}),
  user: { id: "", name: "" },
  setUser: param => set(prev => ({ user : param}))
}));