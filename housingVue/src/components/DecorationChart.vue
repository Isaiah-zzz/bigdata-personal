<template>
    <div>
      <div id="chart" style="width: 600px; height: 400px;"></div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import * as echarts from 'echarts';
  
  export default {
    data() {
      return {
        chartData: []
      };
    },
    mounted() {
      this.fetchCityDemandList();
    },
    methods: {
      fetchCityDemandList() {
        axios.get('http://localhost:8081/house/decoration')
          .then(response => {
            this.chartData = response.data;
            this.renderChart();
          })
          .catch(error => {
            console.error('Error fetching list:', error);
          });
      },
      renderChart() {
        var myChart = echarts.init(document.getElementById('chart'));
        var option = {
          title: {
            left: 'center',
            text: 'Pie chart of housing decoration',
          },
          tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b}: {c} ({d}%)'
          },
          legend: {
            orient: 'vertical',
            left: 10,
            data: this.chartData.map(item => item.decoration)
          },
          series: [{
            name: 'Decor',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: this.chartData.map(item => ({
              name: item.decoration,
              value: item.count
            })),
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }]
        };
        myChart.setOption(option);
      }
    }
  };
  </script>
  