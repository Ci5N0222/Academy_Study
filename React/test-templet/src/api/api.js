import axios from "axios";

/* Member */
export const signInAPI = async () => {
  return await axios.get("mock-data/login.json");

}

export default {
  signInAPI
}