import axios from "axios";
import {useAuthStore} from "../store/store";

export const host = "http://192.168.1.7"

// Create Custom Axios
export const api = axios.create({
  baseURL: `${host}`
});

/** code → axios **/
// API 요청 시 매번 Header에 JWT 토큰을 추가할 필요 없이 사용 가능
api.interceptors.request.use(
  config => {
    const token = sessionStorage.getItem("token");
    if(token) config.headers["Authorization"] = `Bearer ${token}`;
    return config;
  }
);

// 서버 응답에 따라 인터셉트
api.interceptors.response.use(
  res => res,
  err => {
    switch (err.response.status) {
      case 401:
        sessionStorage.removeItem("token");
        useAuthStore.getState().logout();
        break;
    }
  }
)