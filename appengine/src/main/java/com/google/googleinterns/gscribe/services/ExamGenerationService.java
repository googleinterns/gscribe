/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.googleinterns.gscribe.services;

import com.google.googleinterns.gscribe.models.Exam;
import com.google.googleinterns.gscribe.resources.io.request.ExamRequest;
import com.google.googleinterns.gscribe.services.data.ExamSource;

public interface ExamGenerationService {

    /**
     * makes examMetadata object
     * makes an arraylist of questions
     * returns exam object
     *
     * @param examSource ( contains sheet instance containing exam )
     * @param request    ( contains spreadsheetId and sheetName )
     * @param userID     ( unique user ID of user )
     * @return Exam object
     */
    Exam generate(ExamSource examSource, ExamRequest request, String userID);

}
