import React, {useState} from "react";
import DaumPostcode from 'react-daum-postcode';
import Modal from 'react-modal';

export const Postcode = () => {

  const [zipCode, setZipCode] = useState("");
  const [roadAddress, setRoadAddress] = useState("");
  const [detailAddress, setDetailAddress] = useState("");
  const [isOpen, setIsOpen] = useState(false);

  const completeHandler = (data) => {
    setZipCode(data.zonecode); 
    setRoadAddress(data.roadAddress);
    setIsOpen(false);
  }

  const customStyles = {
    overlay: { 
      backgroundColor: "rgba(0, 0, 0, 0.5)",
    },
    content: { 
      left: "0",
      margin: "auto",
      width: "500px",
      height: "600px",
      padding: "0",
      overflow: "hidden",
    }
  };

  // 검색 클릭
  const toggle = () => {
    setIsOpen(!isOpen);
  }

  const changeHandler = (e) => {
    setDetailAddress(e.target.value);
  }

  const cliockHandler = () => {
    if(detailAddress === "") {
      alert("상세주소를 입력해주세요");
    } else {
      console.log(zipCode, roadAddress, detailAddress);
    }
  }

  return (
    <div>
      <input type="text" value={zipCode} readOnly placeholder="우편번호" />
      <button onClick={ toggle }>우편번호 검색</button>
      <br />
      <input type="text" value={ roadAddress } readOnly placeholder="도로명 주소" />
      <br />
      <Modal isOpen={ isOpen } ariaHideApp={false} style={customStyles}>
        <DaumPostcode onComplete={ completeHandler }/>
      </Modal>
      <input type="text" onChange={ changeHandler } value={detailAddress} placeholder="상세주소" />
      <br />
      <button onClick={ cliockHandler }> 클릭 </button>
    </div>
  );

}