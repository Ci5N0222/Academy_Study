import { create } from 'zustand';

export const useMemberStore = create( set => ({
  memberKeys: ["id", "name", "email", "role"],
  member: { id: 0, name: "", email: "", role: "" },
  members: [
    {id: 1, name: "김범수", email: "test1@google.com", role: "관리자"},
    {id: 2, name: "나얼", email: "test2@google.com", role: "사용자"},
    {id: 3, name: "박효신", email: "test3@google.com", role: "사용지"},
    {id: 4, name: "이수", email: "test4@google.com", role: "관리자"},
  ],
  addMember: param => set( prev => ({ members: [ ...prev.members, param ]})),
  delMember: param => set( prev => ({ members: prev.members.filter( item => item.id !== param )})),
  modMember: param => set( prev => ({ members: prev.members.map( item => item.id === param.id ? param : item)}))
}));

export const useCafeStore = create( set => ({
  menuKeys: ["id", "name", "price", "type"],
  menu: { id: 0, name: "", price: 0, type: ""},
  menus: [
    { id: 1, name: "아메리카노", price: 2000, type: "커피"},
    { id: 2, name: "콜드브루", price: 3500, type: "커피"},
    { id: 3, name: "오렌지주스", price: 4000, type: "주스"},
    { id: 4, name: "사과주스", price: 4000, type: "주스"}
  ],
  addMenu: param => set( prev => ({ menus : [ ...prev.menus, param] })),
  delMenu: param => set ( prev => ({ menus : prev.menus.filter( item => item.id !== param) })),
  modMenu: param => set (prev => ({ menus: prev.menus.map(item => item.id === param.id ? param : item) }))
}));

export const useBoardStore = create(set => ({
  boardKeys: ["id", "title", "content", "writer"],
  board: { id: 0, title: "", content: "", writer: "" },
  boards: [
    { id: 1, title: "리액트 어렵다", content: "리액트 초 어렵다",  writer: "스프링장인"},
    { id: 2, title: "스프링 어렵다", content: "스프링 초 어렵다",  writer: "리액트장인"},
    { id: 3, title: "리액트 쉽다", content: "리액트 초 쉽다",  writer: "리액트장인"},
    { id: 4, title: "스프링 쉽다", content: "스프링 초 쉽다",  writer: "스프링장인"},
  ],
  addBoard: param => set(prev => ({ boards: [ ...prev.boards, param ] })),
  delBoard: param => set(prev => ({ boards: prev.boards.filter(item => item.id !== param)  })),
  modBoard: param => set(prev => ({ boards: prev.boards.map(item => item.id === param.id ? param : item) }))
}));