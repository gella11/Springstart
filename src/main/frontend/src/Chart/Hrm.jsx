import React , {useState} from 'react';
import Styles from './Hrm.css'

export default function Hrm(){
    return(
        <div>
            <div className="searchbox">
                <select>
                    <option  value="" selected disabled hidden>부서</option>
                    <option  value="기획">기획</option>
                    <option  value="운영">운영</option>
                    <option  value="개발">개발</option>
                </select>
                <input type="text"/>
                <button type="button"> 검색 </button>
            </div>
            <div>
                <button type="button"> 추가 </button>
            </div>
            <div className="people_box">
                <table className="people">
                    <tr className="people_title">
                        <th> 부서 </th>
                        <th> 이름 </th>
                        <th> 직급 </th>
                        <th> 입사년도 </th>
                        <th> 평가서 </th>
                        <th> 인사고과평가서 </th>
                    </tr>
                    <tr className="people_list">
                        <td> 기획 </td>
                        <td> 사원 </td>
                        <td> 김원종 </td>
                        <td> 2022-12-07 </td>
                        <td> - </td>
                        <td> 조회 </td>
                    </tr>
                    <tr className="people_list">
                        <td> 운영 </td>
                        <td> 만년대리 </td>
                        <td> 손흥민 </td>
                        <td> 2022-02-15 </td>
                        <td> - </td>
                        <td> 조회 </td>
                    </tr>
                    <tr className="people_list">
                        <td> 개발 </td>
                        <td> 부장 </td>
                        <td> 김원종 </td>
                        <td> 2012-06-08 </td>
                        <td> - </td>
                        <td> 조회 </td>
                    </tr>
                </table>
            </div>
        </div>
    )
}