<template>
  <div
    id="app"
    class="container"
  >
    <aside class="sidebar">
      <div class="sidebar-buttons">
        <button
          @click="selectedComponent = 'DecorationChart'"
          class="sidebar-button"
        >House Decoration</button>
        <button
          @click="selectedComponent = 'ElevatorChart'"
          class="sidebar-button"
        >Elevators</button>
        <button
          @click="selectedComponent = 'TotalChart'"
          class="sidebar-button"
        >Housing Price Total</button>
        <button
          @click="selectedComponent = 'DistrictChart'"
          class="sidebar-button"
        >Housing total base on district</button>

      </div>
    </aside>
    <main>
      <header style="display: flex; justify-content: space-between; align-items: center;">
        <h2>{{ pageTitle }}</h2>
      </header>

      <section class="content">
        <component :is="selectedComponent" />
      </section>
    </main>
  </div>
</template>

<script>
import DecorationChart from "./components/DecorationChart.vue";
import DistrictChart from "./components/DistrictChart.vue";
import ElevatorChart from './components/ElevatorChart.vue';
import TotalChart from './components/TotalChart.vue';

export default {
  name: "App",
  components: {
    DecorationChart,
    DistrictChart,
    ElevatorChart,
    TotalChart
  },
  data() {
    return {
      selectedComponent: "DistrictChart", 
      pageTitle: "Rental Info Visualization",
    };
  },
};
</script>

<style>

html,
body {
  overflow: hidden; 
}

#app {
  display: flex;
  height: 100vh;
}

.container {
  width: 100%;
}

.sidebar {
  width: 200px;
  background-color: #545c64; 
  color: white; 
  padding: 20px;
}

.sidebar-buttons {
  display: flex;
  flex-direction: column;
}

.sidebar-button {
  padding: 10px;
  margin-bottom: 10px;
  cursor: pointer;
  background-color: #545c64;
  color: white;
  border: none;
}

.sidebar-button:hover {
  background-color: #6b757d;
}

main {
  flex-grow: 1;
}

header {
  /* background-color: blanchedalmond;  */
  padding: 10px 20px; 
  text-align: left;
  border-bottom: 1px solid #ccc;
  font-size: 14px;
  font-weight: normal;
}

.content {
  padding: 20px;
}
</style>
