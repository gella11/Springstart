import React from 'react';
// install (please make sure versions match peerDependencies)
// yarn add @nivo/core @nivo/radar
import { ResponsiveRadar } from '@nivo/radar'

// make sure parent container have a defined height when using
// responsive component, otherwise height will be 0 and
// no chart will be rendered.
// website examples showcase many properties,
// you'll often use just a few of them.

const data = [
               {
                 "taste": "fruity",
                 "chardonay": 33,
                 "carmenere": 44,
                 "syrah": 47
               },
               {
                 "taste": "bitter",
                 "chardonay": 104,
                 "carmenere": 74,
                 "syrah": 77
               },
               {
                 "taste": "heavy",
                 "chardonay": 59,
                 "carmenere": 23,
                 "syrah": 33
               },
               {
                 "taste": "strong",
                 "chardonay": 88,
                 "carmenere": 81,
                 "syrah": 35
               },
               {
                 "taste": "sunny",
                 "chardonay": 114,
                 "carmenere": 35,
                 "syrah": 36
               }
             ]

const MyResponsiveRadar = ({ data /* see data tab */ }) => (
    <ResponsiveRadar
        data={data}
        keys={[ 'chardonay', 'carmenere', 'syrah' ]}
        indexBy="taste"
        valueFormat=" >-.2f"
        margin={{ top: 70, right: 80, bottom: 40, left: 80 }}
        borderWidth={3}
        borderColor={{ from: 'color', modifiers: [] }}
        gridLabelOffset={38}
        dotSize={8}
        dotColor={{ theme: 'background' }}
        dotBorderWidth={2}
        dotLabelYOffset={-11}
        colors={{ scheme: 'pink_yellowGreen' }}
        fillOpacity={0.65}
        blendMode="multiply"
        motionConfig="wobbly"
        legends={[
            {
                anchor: 'top-left',
                direction: 'column',
                translateX: -50,
                translateY: -40,
                itemWidth: 80,
                itemHeight: 20,
                itemTextColor: '#999',
                symbolSize: 12,
                symbolShape: 'circle',
                effects: [
                    {
                        on: 'hover',
                        style: {
                            itemTextColor: '#000'
                        }
                    }
                ]
            }
        ]}
    />
)

export default MyResponsiveRadar;