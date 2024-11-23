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
          const response = await axios.get('http://localhost:8081/house/district');
          const data = response.data;
          this.chartData = data;
          this.renderChart();
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      },
      renderChart() {
        const chart = echarts.init(this.$refs.chart);
  
        const seriesData = this.chartData.map(item => ({
          name: item.district,
          value: item.count,
        }));
  
        const option = {
          title: {
            text: 'District Housing count',
            left: 'center',
          },
          tooltip: {},
          series: [{
            name: 'Count',
            type: 'pie',
            radius: '55%',
            center: ['50%', '60%'],
            data: seriesData,
            roseType: 'radius',
            label: {
              formatter: '{b}: {c} ({d}%)',
            },
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)',
              },
            },
          }],
        };
  
        chart.setOption(option);
      },
    },
  };
  </script>
  