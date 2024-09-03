import axios from "axios";
import {host} from "../config/config";

const baseUrl = `${host}/employee`

export const empUpdate = (req) => {
  return axios.put(`${baseUrl}`, req);
}

export const empList = () => {
  return axios.get(`${baseUrl}`);
}

export const empDelete = (id) => {
  return axios.delete(`${baseUrl}/${id}`);
}

export const empSearchByName = (name) => {
  return axios.get(`${baseUrl}/name/${name}`);
}

export const empSearchByPhone = (phone) => {
  console.log("phone === ",phone);
  return axios.get(`${baseUrl}/phone/${phone}`);
}
