<template>
  <el-tabs v-model="activeName" type="card">
    <el-tab-pane label="部门管理" name="depMana"><DepMana></DepMana></el-tab-pane>
    <el-tab-pane label="职位管理" name="posMana"><PosMana></PosMana></el-tab-pane>
    <el-tab-pane label="职称管理" name="jobLevelMana"><JobLevelMana></JobLevelMana></el-tab-pane>
    <el-tab-pane label="奖惩规则" name="ecMana"><EcMana></EcMana></el-tab-pane>
    <el-tab-pane label="权限组" name="permissMana"><PermissMana></PermissMana></el-tab-pane>
  </el-tabs>
</template>
<script>
  import DepMana from '../../components/system/basic/DepMana'
  import EcMana from '../../components/system/basic/EcMana'
  import JobLevelMana from '../../components/system/basic/JobLevelMana'
  import PermissMana from '../../components/system/basic/PermissMana'
  import PosMana from '../../components/system/basic/PosMana'
  export default {
    name:'SysBasic',
    data() {
      return {
        activeName: 'posMana'
      };
    },
    components: {
      DepMana,
      EcMana,
      JobLevelMana,
      PermissMana,
      PosMana
    }
  };
</script>