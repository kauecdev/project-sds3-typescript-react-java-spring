import { useState, useEffect } from 'react';
import axios from 'axios';
import Chart from 'react-apexcharts';

import { BASE_URL } from 'utils/requests';
import { round } from 'utils/format';

import { SaleSuccess } from 'types/sale';

type SeriesData = {
  name: string;
  data: number[];
}

type ChartData = {
  labels: {
    categories: string[];
  };
  series: SeriesData[];
}

const BarChart = () => {
  const [chartData, setChartData] = useState<ChartData>({
    labels: {
      categories: []
    },
    series: [
      {
        name: "",
        data: []
      }
    ]
  });

  useEffect(() => {
    axios.get(`${BASE_URL}/sales/success-by-seller`)
      .then(response => {
        const data = response.data as SaleSuccess[];
        const myLabels = data.map(item => item.sellerName);
        const mySeries = data.map(item => 
          round(100.0 * (item.deals / item.visited), 1));

        setChartData({
          labels: {
            categories: myLabels
          },
          series: [
            {
              name: "% Sucesso",
              data: mySeries
            }
          ]
        });
      });
  }, []);

  const options = {
    plotOptions: {
      bar: {
        horizontal: true,
      }
    },
  };

  return (
    <Chart
      options={{
        ...options,
        xaxis: chartData.labels,
      }}
      series={chartData.series}
      type="bar"
      height="240"
    />
  );
}

export default BarChart;