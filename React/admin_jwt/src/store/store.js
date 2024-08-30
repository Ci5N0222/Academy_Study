import {create} from "zustand";

export const useAuthStore = create(set => ({
  token: null,
  isAuth: false,
  login: token => set({token: token, isAuth: true}),
  logout: () => set({token: null, isAuth: false}),
  setIsAuth: param => set({isAuth: param})
}));

