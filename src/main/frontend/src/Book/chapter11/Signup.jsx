import React,{  useState } from 'react';

export default function(props){

    // 이름
    const [ name , setName ] = useState("")
    const handleChangeName = (e) => { setName(e.target.value)}
    // 성별
    const [ gender , setGender ] = useState("")
    const handleChangeGender = (e) => { setGender(e.target.value)}
    // 보내기
    const handleSubmit = (event) => { alert(`이름 : ${name} , 성별 : ${gender} `); event.preventDefault(); }




    return(
        <form onSubmit={handleSubmit}>
            <label>
                이름 : <input type="text"  value={name} onChange={handleChangeName} /> <br/>
            </label>
            <label>
                성별 :
                <select value={gender} onChange={handleChangeGender}>
                    <option value="남자"> 남자 </option>
                    <option value="여자"> 여자 </option>
                </select> <br/>
            </label>
            <button type="submit"> 제출 </button>
        </form>
    );

}