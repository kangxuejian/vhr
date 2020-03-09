import { getRequest} from './api'


export const initMenu = (router,store)=> {
    if (store.state.routes.length > 0 ) {
        return
    }
    getRequest("/system/config/menu").then(resp=> {
        if(resp) {
            let fmRoutes = formatRoutes(resp);
            router.addRoutes(fmRoutes);
            store.commit('initRoute',fmRoutes);
            store.dispatch('connect');
        }
    })
}

/**
 * component转化为对象
 */
export const formatRoutes = (routes)=> {
    let fmRoutes = []
    routes.forEach(router=>{
        let {
            path,
            component,
            name,
            meta,
            iconCls,
            children
        } = router   //批量的变量定义
        //递归
        if(children && children instanceof Array) {
            children = formatRoutes(children)
        }
        let fmRouter = {
            path: path,
            component(resolve){
                if(component.startsWith("Home")) {
                    require(['../views/'+component + '.vue'],resolve)
                }else if(component.startsWith("Emp")){
                    require(['../views/emp/'+component + '.vue'],resolve)
                }else if(component.startsWith("Per")){
                    require(['../views/personnel/'+component + '.vue'],resolve)
                }else if(component.startsWith("Sal")){
                    require(['../views/salary/'+component + '.vue'],resolve)
                }else if(component.startsWith("Sta")){
                    require(['../views/statistics/'+component + '.vue'],resolve)
                }else if(component.startsWith("Sys")){
                    require(['../views/system/'+component + '.vue'],resolve)
                }

            },
            name: name,
            iconCls: iconCls,
            meta: meta,
            children: children  //已经是格式化的children
        }
        fmRoutes.push(fmRouter)
    })
    return fmRoutes
}