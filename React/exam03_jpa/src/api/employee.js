import axios from "axios";
import {host} from "../config/config";

const baseUrl = `${host}/employee`

export const empUpdate = (req) => {
  return axios.put(`${baseUrl}/${req.empId}`, req);
}

export const empList = () => {
  return axios.get(`${baseUrl}`);
}

export const empDelete = (id) => {
  return axios.delete(`${baseUrl}/${id}`);
}

export const empSearch = (type, data) => {
  const param = type === "phone" ? data.phone : data.empName;
  return axios.get(`${baseUrl}/${type}/${param}`);
}
