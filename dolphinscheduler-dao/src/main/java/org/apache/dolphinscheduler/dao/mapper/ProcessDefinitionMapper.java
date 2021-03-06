/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.dao.mapper;

import org.apache.dolphinscheduler.dao.entity.DefinitionGroupByUser;
import org.apache.dolphinscheduler.dao.entity.ProcessDefinition;
import org.apache.dolphinscheduler.dao.entity.ProcessDefinitionLog;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * process definition mapper interface
 */
public interface ProcessDefinitionMapper extends BaseMapper<ProcessDefinition> {

    /**
     * query process definition by code
     *
     * @param code code
     * @return process definition
     */
    ProcessDefinition queryByCode(@Param("code") Long code);

    /**
     * query process definition by code list
     *
     * @param codes codes
     * @return process definition list
     */
    List<ProcessDefinition> queryByCodes(@Param("codes") Collection<Long> codes);

    /**
     * delete process definition by code
     *
     * @param code code
     * @return delete result
     */
    int deleteByCode(@Param("code") Long code);
    
    /**
     * verify process definition by name
     *
     * @param projectCode projectCode
     * @param name name
     * @return process definition
     */
    ProcessDefinition verifyByDefineName(@Param("projectCode") Long projectCode,
                                        @Param("processDefinitionName") String name);

    /**
     * query process definition by name
     *
     * @param projectCode projectCode
     * @param name name
     * @return process definition
     */
    ProcessDefinition queryByDefineName(@Param("projectCode") Long projectCode,
                                        @Param("processDefinitionName") String name);

    /**
     * query process definition by id
     *
     * @param processDefineId processDefineId
     * @return process definition
     */
    ProcessDefinition queryByDefineId(@Param("processDefineId") int processDefineId);

    /**
     * process definition page
     *
     * @param page page
     * @param searchVal searchVal
     * @param userId userId
     * @param projectCode projectCode
     * @param isAdmin isAdmin
     * @return process definition IPage
     */
    IPage<ProcessDefinition> queryDefineListPaging(IPage<ProcessDefinition> page,
                                                   @Param("searchVal") String searchVal,
                                                   @Param("userId") int userId,
                                                   @Param("projectCode") Long projectCode,
                                                   @Param("isAdmin") boolean isAdmin);

    /**
     * query all process definition list
     *
     * @param projectCode projectCode
     * @return process definition list
     */
    List<ProcessDefinition> queryAllDefinitionList(@Param("projectCode") Long projectCode);

    /**
     * query process definition by ids
     *
     * @param ids ids
     * @return process definition list
     */
    List<ProcessDefinition> queryDefinitionListByIdList(@Param("ids") Integer[] ids);

    /**
     * query process definition by tenant
     *
     * @param tenantId tenantId
     * @return process definition list
     */
    List<ProcessDefinition> queryDefinitionListByTenant(@Param("tenantId") int tenantId);

    /**
     * count process definition group by user
     *
     * @param userId userId
     * @param projectCodes projectCodes
     * @param isAdmin isAdmin
     * @return process definition list
     */
    List<DefinitionGroupByUser> countDefinitionGroupByUser(
            @Param("userId") Integer userId,
            @Param("projectCodes") Long[] projectCodes,
            @Param("isAdmin") boolean isAdmin);

    /**
     * list all resource ids
     *
     * @return resource ids list
     */
    @MapKey("id")
    List<Map<String, Object>> listResources();

    /**
     * list all resource ids by user id
     *
     * @return resource ids list
     */
    @MapKey("id")
    List<Map<String, Object>> listResourcesByUser(@Param("userId") Integer userId);

    /**
     * update process definition version by process definitionId
     *
     * @param processDefinitionId process definition id
     * @param version version
     */
    void updateVersionByProcessDefinitionId(@Param("processDefinitionId") int processDefinitionId, @Param("version") long version);

    /**
     * list all project ids
     * @return project ids list
     */
    List<Integer> listProjectIds();


    /**
     * query the paging process definition version list by pagination info
     *
     * @param page pagination info
     * @param processDefinitionCode process definition code
     * @return the paging process definition version list
     */
    IPage<ProcessDefinitionLog> queryProcessDefinitionVersionsPaging(Page<ProcessDefinitionLog> page,
                                                                         @Param("processDefinitionCode") Long processDefinitionCode);
    /**
     * query has associated definition by id and version
     * @param processDefinitionId process definition id
     * @param version version
     * @return definition id
     */
    Integer queryHasAssociatedDefinitionByIdAndVersion(@Param("processDefinitionId") int processDefinitionId, @Param("version") long version);
}
