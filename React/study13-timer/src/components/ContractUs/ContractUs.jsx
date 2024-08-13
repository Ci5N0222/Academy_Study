import emailjs from '@emailjs/browser';

export const ContractUs = () => {

    const { REACT_APP_EMAIL_SERVICE_ID, REACT_APP_EMAIL_TEMPLATE_ID, REACT_APP_EMAIL_PUBLIC_KEY} = process.env;

    const sendEmail = (data) => {
        emailjs.send(REACT_APP_EMAIL_SERVICE_ID, REACT_APP_EMAIL_TEMPLATE_ID, data, {
            publicKey: REACT_APP_EMAIL_PUBLIC_KEY
        }).then(res => {
           console.log(res);
           console.log("success");
        })
    }


    const handleSendEmail = (e) => {
        const data = {
            message: 123456,
            to_name: "Sion-Noh"
        }
        sendEmail(data);
        console.log("이메일 보낼거임");
        e.preventDefault();

    }

    return(
        <button onClick={ handleSendEmail }>이메일 전송</button>
    );
}