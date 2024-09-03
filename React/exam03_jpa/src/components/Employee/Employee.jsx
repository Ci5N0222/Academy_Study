import {useState} from "react";
import {empDelete, empList, empSearch, empUpdate} from "../../api/employee";

export const Employee = () => {

  const [employees, setEmployees] = useState([]);
  const [search, setSearch] = useState([]);
  const [modifyData, setModifyData] = useState({empId: "", empName: "", phone: "", salary: 0})
  const [delId, setDelId] = useState("");
  const [searchData, setSearchData] = useState({phone:"", empName:""});


  /**************************************** 데이터 셋 ****************************************/
  // 업데이트 데이터
  const handleChangeModDate = (e) => {
    const {name, value} = e.target;
    setModifyData(prev=> ({ ...prev, [name]: value }));
  }

  // 삭제 데이터
  const handleChangeDeleteId = (e) => setDelId(e.target.value);

  // 검색 데이터
  const handleChangeSearchDate = (e) => {
    const {name, value} = e.target;
    setSearchData(prev => ({ ...prev, [name]: value }));
  }
  /***************************************************************************************** /

  /** 직원 목록 **/
  const handleGetList = () => {
    empList().then(res =>{
      setEmployees(res.data);
      setSearch(res.data);
    });
  }

  /** 목록 지우기 **/
  const handleListReset = () => {
    setEmployees([]);
    setSearch([]);
  }

  /** 직원 정보 수정 **/
  const handleUpdate = () => {
    empUpdate(modifyData).then(res => {
      handleGetList();
    });
  }

  /** 직원 삭제 **/
  const handleDelete = () => {
    empDelete(delId).then(res => {
      handleGetList();
    });
  }

  /** 직원 검색 (이름, 전화번호, 급여 ) **/
  const handleSearch = (type) => {
    if(searchData.phone === "" && searchData.empName === "") return false;
    empSearch(type, searchData).then(res => {
      setSearch(res.data);
    });
  }

  return (
    <div>
      <h1>Employee Management</h1>

      <fieldset>
        <legend>Employee List</legend>
        <button onClick={handleGetList}>Get List</button>
        <button onClick={handleListReset}>Delete List</button>
      </fieldset>

      <fieldset>
        <legend>Update Employee</legend>
        <input type="text" name="empId" onChange={handleChangeModDate} placeholder="Employee ID"/><br/>
        <input type="text" name="empName" onChange={handleChangeModDate} placeholder="Employee Name"/><br/>
        <input type="text" name="phone" onChange={handleChangeModDate} placeholder="Employee Phone"/><br/>
        <input type="text" name="salary" onChange={handleChangeModDate} placeholder="Employee Salary"/><br/>
        <button onClick={handleUpdate}>Update</button>
      </fieldset>

      <fieldset>
        <legend>Delete Employee</legend>
        <input type="text" name="name" onChange={handleChangeDeleteId} placeholder="Employee Delete by ID"/>
        <button onClick={handleDelete}>Delete</button>
      </fieldset>

      <fieldset>
        <legend>Search Employee by Name</legend>
        <input type="text" name="empName" onChange={handleChangeSearchDate} placeholder="Employee Name"/>
        <button onClick={() => handleSearch("name")}>Search</button>
      </fieldset>

      <fieldset>
        <legend>Search Employee by Phone</legend>
        <input type="text" name="phone" onChange={handleChangeSearchDate} placeholder="Employee Phone"/>
        <button onClick={() => handleSearch("phone")}>Search</button>
      </fieldset>

      <fieldset>
        <legend>Search Employee by Salary Greater than</legend>
        <input type="text" name="empName" onChange={handleChangeSearchDate} placeholder="Employee Name"/>
        <button onClick={() => handleSearch("salary")}>Search</button>
      </fieldset>

      <fieldset>
        <legend>Employee List</legend>
        {
          search.map(item => {
            return (
              <div key={item.empId} style={{border: "1px solid black"}}>
                <p>ID : {item.empId}</p>
                <p>이름 : {item.empName}</p>
                <p>전화번호 : {item.phone}</p>
                <p>급여 : {item.salary}원</p>
                <p>입사일 : {item.hire_date}</p>
              </div>
            );
          })
        }
      </fieldset>

    </div>
  );
}