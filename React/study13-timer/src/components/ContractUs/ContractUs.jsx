import emailjs from '@emailjs/browser';

export const ContractUs = () => {

    const handleSendEmail = (e) => {
        console.log("이메일 보낼거임");
        e.preventDefault();

    }

    return(
        <button onClick={ handleSendEmail }>이메일 전송</button>
    );
}