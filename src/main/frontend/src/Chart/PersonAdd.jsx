import React , {useState, useEffect} from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css'; // css import
import moment from 'moment';

export default function PersonAdd(){


      const [value, onChange] = useState(new Date());
      const [ isFull , setIsFull  ] = useState( false );

      const btn = () => {  setIsFull(!isFull); } ;
      const btn2 = () => {  if(isFull){setIsFull(!isFull)} } ;
      //useEffect( () => { console.log(value) }  )

      //  const value = moment().format('YYYY-MM-DD');
      const abc = () => {  onChange => moment(value).format('YYYY-MM-DD') } ;


    return(
    <div>
        <div >
            <select>
                <option  value="" selected disabled hidden>부서</option>
                <option  value="기획">기획</option>
                <option  value="운영">운영</option>
                <option  value="개발">개발</option>
            </select>
        </div>
        <div>
           <select>
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
            <input type="text" className="name" />
        </div>
        <div>

            { isFull && <div> <Calendar onChange={onChange} value={value} /> </div>  }
            <button onClick={btn}> btn </button>
            <button onClick={abc}> change </button>
            <input type="text" value={value} / >

        </div>
        <div>

        </div>
        <div>
            <input type="text" className="pay" /> 원
        </div>
        <div>
            <select>
               <option  value="" selected disabled hidden>프로젝트</option>
               <option  value="싸이콘서트">싸이콘서트</option>
               <option  value="장보기">장보기</option>
               <option  value="요리레시피찾기">요리레시피찾기</option>
           </select>
        </div>

    </div>


    );
}