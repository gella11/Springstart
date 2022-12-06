import React, { PureComponent } from 'react';
import Chart2 from './Chart2'
import Styles from './Box.css'
import axios from 'axios';  // react 비동기 통신 라이브러리

import {  Legend , Radar, RadarChart, PolarGrid, PolarAngleAxis, PolarRadiusAxis, ResponsiveContainer } from 'recharts';



export default function Evaluation(){

                                        /*
                                            axios
                                                .get("")
                                                .then( (re) => {  })

                                        */

    let A1 = 12;
    let A2 = 10;
    let A3 = 8;
    let A4= 6;
    let A5 = 4;

    const data = [
          {
            subject: '이해력',
            A: A1,
            B: 6,
            fullMark: 0,
          },
          {
            subject: '업무력',
            A: A2,
            B: 6,
            fullMark: 0,
          },
          {
            subject: '적극성',
            A: A3,
            B: 6,
            fullMark: 0,
          },
          {
            subject: '창의력',
            A: A4,
            B: 6,
            fullMark: 0,
          },
          {
            subject: '사회성',
            A: A5,
            B: 6,
            fullMark: 0,
          },

        ];


    return(
        <div className="box">
            <h3> 인사고과 평가서 </h3>
            <div className="person">
                <span className="picture"> 증명사진 </span>
                <span className="intro">
                    <div> 인적사항 </div>
                    <div> 이름 : 김아무개 </div>
                    <div> 부서 : 마케팅 </div>
                    <div> 직위 : 사원 </div>
                </span>
                <span className="grade">
                    <div>등급</div>
                    <div> S </div>
                </span>
            </div>

            <div className="inform">
                <table className="main">
                  <tr>
                    <th className="item">평가항목</th>
                    <th className="point">점수</th>
                    <th className="grape">그래프</th>
                  </tr>
                  <tr>
                    <td>{data[0].subject}</td>
                    <td>{data[0].A}</td>
                    <td rowspan='7'>
                            <RadarChart outerRadius={90} width={730} height={250} data={data}>
                               <PolarGrid />
                               <PolarAngleAxis dataKey="subject" />
                               <PolarRadiusAxis angle={90} domain={[0, 12]} />
                               <Radar name="Mike" dataKey="A" stroke="#8884d8" fill="#8884d8" fillOpacity={0.6} />
                               <Legend />
                           </RadarChart>
                      </td>
                  </tr>
                  <tr>
                    <td>{data[1].subject}</td>
                    <td>{data[1].A}</td>
                  </tr>
                  <tr>
                    <td>{data[2].subject}</td>
                    <td>{data[2].A}</td>
                  </tr>
                  <tr>
                    <td>{data[3].subject}</td>
                    <td>{data[3].A}</td>
                  </tr>
                  <tr>
                    <td>{data[4].subject}</td>
                    <td>{data[4].A}</td>
                  </tr>
                  <tr>
                    <td>합계</td>
                    <td>
                        {(data[0].A+data[1].A+data[2].A+data[3].A+data[4].A)/5}
                    </td>
                  </tr>
                </table>

                <div> 1점 : 부족함 ||  4점 : 다소 미흡함 || 6점 : 보통 || 8점 : 기대수준이상 || 12점: 우수함 </div>

                <div> 종합의견  </div>

                <div text="opinion">
                    1.모르면 찾아서 할 끈기가 있지만 농땡이를 조금 핌 <br/>
                    2.잘못하면 후배한테 잡아먹히니 조심할 것 <br/>
                    3.실령은 출중
                </div>
         </div>
         </div>
    );
}