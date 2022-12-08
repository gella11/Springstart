import React , {useState, useEffect} from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css'; // css import
import Styles from './PersonAdd.css'
import moment from 'moment';

export default function PersonAdd(){


    // 셀렉트 값 추출
            // 부서 셀렉트 값
            const [t_name, setSelected] = useState("");
            const select_team = (e) => { setSelected(e.target.value); };
            // 직책 셀렉트 값
            const [po_name, setSelected2] = useState("");
            const select_position = (e) => { setSelected2(e.target.value); };
            // 포폴 셀렉트 값
            const [pr_name, setSelected3] = useState("");
            const select_project = (e) => { setSelected3(e.target.value); };


    // 달력
            // 날짜 선택
            // 선택한 날짜 포맷
            // 달력 on / off
            const [value, onChange] = useState(new Date());
            const mstart = moment(value).format('YYYY-MM-DD');
            const [ isFull , setIsFull  ] = useState( false );
            const btn = () => {  setIsFull(!isFull); } ;
            const btn2 = () => {  if(isFull){setIsFull(!isFull)} } ;

    // axios
    // 해야할 기능
    // 1) 해당 이름과 , 해당 생년월일 존재 여부
    // 2) 사진 넣기
    // 3) 계좌 자동 넣기
    // 4) 유효성
            const personadd = () => {
                let addinfo = {
                            mname : document.querySelector('.mname').value,
                            mbirth : document.querySelector('.mbirth').value,
                            mphone : document.querySelector('.mphone').value,
                            memail : document.querySelector('.memail').value,
                            msalary : document.querySelector('.msalary').value,
                            mstart : mstart,
                            t_name : t_name,
                            po_name : po_name,
                            pr_name : pr_name
                }
                /*for(let i = 0; i < personadd.addinfo.length; i++) {
                    if(personadd.addinfo[0] == ""){ alert("빈칸있음")}
                }*/
                alert(personadd.addinfo[0])
            }


    return(
    <div className="addbox">
        <div>
            <select className="PersonAdd_team" onChange={select_team}>
                <option  value="" selected disabled hidden>부서</option>
                <option  value="기획">기획</option>
                <option  value="운영">운영</option>
                <option  value="개발">개발</option>
            </select>
        </div>
        <div>
           <select className="PersonAdd_position" onChange={select_position} >
               <option  value="" selected disabled hidden>직책</option>
               <option  value="기획">사원</option>
               <option  value="운영">주임</option>
               <option  value="개발">대리</option>
               <option  value="과장">과장</option>
               <option  value="차장">차장</option>
               <option  value="부장">부장</option>
               <option  value="수석">수석</option>
           </select>
        </div>
        <div>
            <input type="text" className="mname" placeholder="이름" />
        </div>
        <div>
            <input type="text" className="mbirth" placeholder="생년월일" />
        </div>
        <div>
            <input type="text" className="mphone" placeholder="전화번호" />
        </div>
        <div>
            <input type="text" className="memail" placeholder="이메일" />
        </div>
        <div>
            { isFull && <div className="calbox" onClick={btn2}> <Calendar onChange={onChange} value={value} /> </div>  }
            <input type="text" value={mstart}  / > <br/>
            <button onClick={btn}> 입사일 </button>
        </div>
        <div>
            <input type="text" className="msalary" placeholder="연봉" /> 만 원
        </div>
        <div>
            <select className="PersonAdd_project" onChange={select_project}>
               <option  value="" selected disabled hidden>프로젝트</option>
               <option  value="싸이콘서트">싸이콘서트</option>
               <option  value="장보기">장보기</option>
               <option  value="요리레시피찾기">요리레시피찾기</option>
           </select>
        </div>

        <h3> 테스트 버튼 </h3>
        <button onClick={personadd}> 등록 </button>
    </div>


    );
}