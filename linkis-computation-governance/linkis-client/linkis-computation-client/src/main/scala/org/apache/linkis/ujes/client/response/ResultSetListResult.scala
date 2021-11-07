/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.linkis.ujes.client.response

import java.util

import org.apache.linkis.httpclient.dws.annotation.DWSHttpMessageResult
import org.apache.linkis.httpclient.dws.response.DWSResult
import org.apache.linkis.ujes.client.request.UserAction

import scala.beans.BeanProperty
import scala.collection.JavaConversions._

@DWSHttpMessageResult("/api/rest_j/v\\d+/filesystem/getDirFileTrees")
class ResultSetListResult extends DWSResult with UserAction {

  @BeanProperty var dirFileTrees: util.Map[String, Object] = _

  def getResultSetList = if(dirFileTrees != null) dirFileTrees.get("children") match {
    case list: util.List[util.Map[String, Object]] =>
      list.map(_.get("path").asInstanceOf[String]).toArray
    case _ => Array.empty[String]
  } else Array.empty[String]

}