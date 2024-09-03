import {useState} from "react";
import {empDelete, empList, empSearchByName, empSearchByPhone, empUpdate} from "../../api/employee";

export const Employee = () => {

  const [employees, setEmployees] = useState([]);
  const [searchEmp, setSearchEmp] = useState([]);
  const [delId, setDelId] = useState("");
  const [searchData, setSearchData] = useState({phone:"", empName:""});

  const [modifyData, setModifyData] = useState()

  const handleChangeModDate = (e) => {
    const {name, value} = e.target;
    setModifyData(prev=> ({ ...prev, [name]: value }));
  }

  const handleChangeDeleteId = (e) => setDelId(e.target.value);

  const handleChangeSearchDate = (e) => {
    const {name, value} = e.target;
    setSearchData(prev => ({ ...prev, [name]: value }));
  }


  const handleUpdate = () => {
    const response = empUpdate();
    console.log(response);
  }

  /** 직원 검색 (이름, 전화번호 ) **/
  const handleSearch = (type) => {
    if(type === "phone") {
      empSearchByPhone(searchData.phone).then(res => {
        console.log(res.data);
        setSearchEmp(res.data);
      });
    } else {
      empSearchByName(searchData.empName).then(res => {
        console.log(res.data);
        setSearchEmp(res.data);
      });
    }
  }


  /** 직원 목록 **/
  const handleGetList = () => {
    empList().then(res =>{
      setEmployees(res.data);
    });
  }

  /** 목록 지우기 **/
  const handleListReset = () => {
    setEmployees([]);
  }

  /** 직원 삭제 **/
  const handleDelete = () => {
    empDelete(delId).then(res => {
      handleGetList();
    });
  }

  return (
    <div>
      <h1>Employee Management</h1>
      <fieldset>
        <legend>Update Employee</legend>
        <input type="text" name="emp_id" onChange={handleChangeModDate} placeholder="Employee ID"/><br/>
        <input type="text" name="emp_name" onChange={handleChangeModDate} placeholder="Employee Name"/><br/>
        <input type="text" name="phone" onChange={handleChangeModDate} placeholder="Employee Phone"/><br/>
        <input type="text" name="salary" onChange={handleChangeModDate} placeholder="Employee Salary"/><br/>
        <button onClick={handleUpdate}>Update</button>
      </fieldset>

      <fieldset>
        <legend>Search Employee by Name</legend>
        <input type="text" name="empName" onChange={handleChangeSearchDate} placeholder="Employee Name"/>
        <button onClick={() => handleSearch("empName")}>Search</button>
        {
          searchEmp.map(item => {
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

      <fieldset>
        <legend>Search Employee by Phone</legend>
        <input type="text" name="phone" onChange={handleChangeSearchDate} placeholder="Employee Phone"/>
        <button onClick={() => handleSearch("phone")}>Search</button>
      </fieldset>

      <fieldset>
        <legend>Search Employee by Salary Greater than</legend>
        <input type="text" name="empName" onChange={handleChangeSearchDate} placeholder="Employee Name"/>
        <button onClick={handleSearch}>Search</button>
      </fieldset>

      <fieldset>
        <legend>Employee List</legend>
        <button onClick={handleGetList}>Get List</button>
        <button onClick={handleListReset}>Delete List</button>
        {
          employees.map(item => {
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

      <fieldset>
        <legend>Delete Employee</legend>
        <input type="text" name="name" onChange={handleChangeDeleteId} placeholder="Employee Delete by ID"/>
        <button onClick={handleDelete}>Delete</button>
      </fieldset>

    </div>
  );
}