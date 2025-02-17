package com.tencent.wxcloudrun.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: lsp
 * @Description
 * @Date 2022-06-29 17:23
 **/
@AllArgsConstructor
@Data
@NoArgsConstructor
@SuperBuilder
public class FinishedNumResp {

    private Integer finishedNumber;

}
