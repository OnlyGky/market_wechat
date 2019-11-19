package com.in.market.service.afterSale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class FileUploadService {
    @Value("${com.llxs.images.afterSale}")
    public String FILE_URL ;
}
