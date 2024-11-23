<template>
    <div ref="chart" style="width: 600px; height: 400px;"></div>
  </template>
  
  <script>
  import * as echarts from 'echarts';
  import axios from 'axios';
  
  export default {
    data() {
      return {
        chartData: [],
      };
    },
    mounted() {
      this.fetchData();
    },
    methods: {
      async fetchData() {
        try {
          const response = await axios.get('http://localhost:8081/house/elevator');
          this.chartData = response.data;
          this.renderChart();
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      },
      renderChart() {
        const chart = echarts.init(this.$refs.chart);
        const xAxisData = this.chartData.map(item => item.elevator);
        const seriesData = this.chartData.map(item => item.count);
  
        const option = {
          title: {
            text: 'With/Without Elevator Situation',
            left: 'center',
          },
          tooltip: {},
          xAxis: {
            type: 'category',
            data: xAxisData,
          },
          yAxis: {},
          series: [{
            name: 'Count',
            type: 'bar',
            data: seriesData,
          }],
        };
  
        chart.setOption(option);
      },
    },
  };
  </script>
  