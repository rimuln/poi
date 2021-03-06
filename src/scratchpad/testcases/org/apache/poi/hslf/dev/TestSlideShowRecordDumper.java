/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */
package org.apache.poi.hslf.dev;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EmptyFileException;
import org.apache.poi.hslf.HSLFTestDataSamples;
import org.junit.Test;

public class TestSlideShowRecordDumper extends BasePPTIteratingTest {
    @Test
    public void testMain() throws IOException {
        SlideShowRecordDumper.main(new String[] {
                HSLFTestDataSamples.getSampleFile("slide_master.ppt").getAbsolutePath(),
        });

        SlideShowRecordDumper.main(new String[] {
                "-escher",
                HSLFTestDataSamples.getSampleFile("slide_master.ppt").getAbsolutePath(),
        });

        SlideShowRecordDumper.main(new String[] {
                "-verbose",
                HSLFTestDataSamples.getSampleFile("pictures.ppt").getAbsolutePath()
        });

        try {
            SlideShowRecordDumper.main(new String[]{"invalidfile"});
            fail("Should catch exception here");
        } catch (EmptyFileException e) {
            // expected here
        }
    }

    @Override
    void runOneFile(File pFile) throws Exception {
        SlideShowRecordDumper.main(new String[]{pFile.getAbsolutePath()});
    }
}