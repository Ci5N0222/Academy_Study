import { create } from 'zustand';

export const useAuthStore = create( set => ({
    loginID:"",
    setLoginID: param => set({ loginID : param }),
    userInfo: {id:"", name:""},
    setUserInfo : param => set({userInfo: param})
}));