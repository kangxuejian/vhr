<template>
    <div>
        <div>
            <el-input
                size="small"
                class="addPosInput"
                placeholder="添加职位..."
                prefix-icon="el-icon-plus"
                @keydown.enter.native="addPosition"
                v-model="pos.name">
            </el-input>
            <el-button icon="el-icon-plus" size="small" type="primary" @click="addPosition">添加</el-button>
        </div>
        <div>
            <el-table
                :data="position"
                border
                size="small"
                class="posManaMain"
                style="width: 60%"
                @selection-change="handleSelectionChange">
                <el-table-column
                    type="selection"
                    width="55">
                </el-table-column>
                <el-table-column
                    prop="id"
                    label="编号"
                    width="55">
                </el-table-column>
                <el-table-column
                    prop="name"
                    label="职位名称"
                    width="180">
                </el-table-column>
                <el-table-column
                    prop="createDate"
                    label="创建时间"
                    width="180">
                </el-table-column>
                <el-table-column
                    label="是否启用"
                    width="100">
                    <template slot-scope="scope">
                         <el-tag type="success" v-if="scope.row.enabled">已启用</el-tag>
                         <el-tag type="danger" v-else>未启用</el-tag>
                    </template>
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">
                        <el-button
                        size="mini"
                        @click="showEditView(scope.$index, scope.row)">编辑</el-button>
                        <el-button
                        size="mini"
                        type="danger"
                        @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>
            <el-button @click="deleteMany" size="small" type="danger" style="margin-top:8px;" :disabled="multipleSelection.length==0">批量删除</el-button>
        </div>
        <el-dialog
            title="修改职位"
            :visible.sync="dialogVisible"
            width="30%">
            <div>
                <table>
                    <tr>
                        <td><el-tag>职位名称</el-tag></td>
                        <td><el-input class="updatePosInput" size="small" v-model="updatePos.name"></el-input></td>
                    </tr>
                    <tr>
                        <td><el-tag>是否启用</el-tag></td>
                        <td>
                            <el-switch
                                v-model="updatePos.enabled"
                                active-text="启用"
                                inactive-text="禁用">
                            </el-switch>
                        </td>
                    </tr>
                </table>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button size="small" @click="dialogVisible = false">取 消</el-button>
                <el-button size="small" type="primary" @click="doUpdate">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: 'PosMana',
        data() {
            return {
                pos: {
                    name:""
                },
                dialogVisible: false,
                multipleSelection: [],
                updatePos:{
                    name:'',
                    enabled:''
                },
                position: []
            }
            
        },
        mounted(){
            this.initPositions()
        },
        methods: {
            addPosition(){
                if(this.pos.name) {
                    this.postRequest("/system/basic/position",this.pos).then(resp=>{
                        if(resp){
                            this.initPositions();
                            this.pos.name="";
                        }
                    })
                }else{
                    this.$message.error("职位名称不可以为空");
                    
                }
            },
            showEditView(index,data) {
                Object.assign(this.updatePos,data)
                this.dialogVisible = true
            },
            doUpdate() {
                this.putRequest("/system/basic/position",this.updatePos).then(resp=>{
                    if(resp){
                        this.initPositions();
                        this.updatePos.name = '';
                        this.dialogVisible = false;
                    }
                })
            },
            handleDelete(index,data){
                this.$confirm('此操作将永久删除【'+data.name+'】职位, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    this.deleteRequest("/system/basic/position/"+data.id).then(resp=>{
                        if(resp){
                            this.initPositions();
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });          
                });
            },
            deleteMany(){
                this.$confirm('此操作将永久删除【'+this.multipleSelection.length+'】条记录, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let pids = '';
                    this.multipleSelection.forEach(item=>{
                        pids = pids + item.id + ',';
                        
                    })
                    this.deleteRequest("/system/basic/position/"+pids).then(resp=>{
                        if(resp){
                            this.initPositions();
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });          
                });
            },
            initPositions(){
                var _this = this;
                this.getRequest("/system/basic/positions").then(resp =>{
                    if(resp){
                        _this.position = resp;
                    }
                })
            },
            handleSelectionChange(val) {
                this.multipleSelection = val;
            }
        }
    }
</script>

<style>
    .addPosInput{
        width:300px;
        margin-right:8px;
    }
    .updatePosInput{
        width: 200px;
        margin-left: 8px;
    }
    .posManaMain{
        margin-top: 10px;
    }
</style>>
    
