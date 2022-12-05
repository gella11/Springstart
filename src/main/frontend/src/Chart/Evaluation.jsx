import React, { PureComponent } from 'react';
import Chart2 from './Chart2'
import Styles from './Box.css'

import {  Legend , Radar, RadarChart, PolarGrid, PolarAngleAxis, PolarRadiusAxis, ResponsiveContainer } from 'recharts';




export default function Evaluation(){

    const data = [
          {
            subject: '이해력',
            A: 10,
            B: 6,
            fullMark: 0,
          },
          {
            subject: '업무력',
            A: 9,
            B: 6,
            fullMark: 0,
          },
          {
            subject: '적극성',
            A: 6,
            B: 6,
            fullMark: 0,
          },
          {
            subject: '창의력',
            A: 6,
            B: 6,
            fullMark: 0,
          },
          {
            subject: '사회성',
            A: 3,
            B: 6,
            fullMark: 0,
          },

        ];

    return(
        <div className="box">
            <h3> 인사고과 평가서 </h3>
            <div className="person">
                <span> 증명사진 </span>
                <span>
                    <div> 인적사항 </div>
                    <div> 이름 : 김아무개 </div>
                    <div> 부서 : 마케팅 </div>
                    <div> 직위 : 사원 </div>
                </span>
                <span>
                    <div>등급</div>
                    <div> S </div>
                </span>
            </div>

            <div className="chart">
                <table border="1">
                  <tr>
                    <th>평가항목</th>
                    <th>점수</th>
                    <th>그래프</th>
                  </tr>
                  <tr>
                    <td>이해도</td>
                    <td>1</td>
                    <td rowspan='7'>
                            <RadarChart outerRadius={90} width={730} height={250} data={data}>
                               <PolarGrid />
                               <PolarAngleAxis dataKey="subject" />
                               <PolarRadiusAxis angle={30} domain={[0, 150]} />
                               <Radar name="Mike" dataKey="A" stroke="#8884d8" fill="#8884d8" fillOpacity={0.6} />
                               <Radar name="Lily" dataKey="B" stroke="#82ca9d" fill="#82ca9d" fillOpacity={0.6} />
                               <Legend />
                           </RadarChart>
                      </td>
                  </tr>
                  <tr>
                    <td>적극성</td>
                    <td>2</td>
                  </tr>
                  <tr>
                    <td>책임감</td>
                    <td>1</td>
                  </tr>
                  <tr>
                    <td>독창성</td>
                    <td>1</td>
                  </tr>
                  <tr>
                    <td>노력도</td>
                    <td>1</td>
                  </tr>
                  <tr>
                    <td>근면성</td>
                    <td>1</td>
                  </tr>
                  <tr>
                    <td>함계</td>
                    <td>1</td>
                  </tr>
                </table>

                <div> 1점 : 부족함 2점 : 다소 미흡함 3점 : 보통 4점 : 기대수준이상 5점: 우수함 </div>

                <div> 종합의견  </div>

                <div text="opinion">
                    모르면 찾아서 할 끈기가 있지만 농땡이를 조금 핌 <br/>
                    잘못하면 후배한테 잡아먹히니 조심할 것 <br/>
                    실령은 출중
                </div>
         </div>
         </div>
    );
}