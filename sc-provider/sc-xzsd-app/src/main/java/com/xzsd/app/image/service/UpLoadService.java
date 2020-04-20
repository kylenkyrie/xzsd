package com.xzsd.app.image.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

@Service
public class UpLoadService {
    public AppResponse upLoadImage(MultipartFile imageFile) {
        // 1 初始化用户身份信息API密钥(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials("AKIDf7LMAhCdDWS9csmuc6KJ6lt6sl9LP6an", "6wYwmLdgS0HRMFwMVQt6ViLhmbAWasd8");
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        ClientConfig clientConfig = new ClientConfig(new Region("ap-shenzhen-fsi"));
        // 3 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // 存储桶bucket名需包含appid
        String bucketName = "xzsd-1301787137";
        // 指定要上传到 COS 上对象键
        // 对象键（Key）是对象在存储桶中的唯一标识。例如，在对象的访问域名 `bucket1-1250000000.cos.ap-guangzhou.myqcloud.com/doc1/pic1.jpg` 中，对象键为 doc1/pic1.jpg, 详情参考 [对象键](https://cloud.tencent.com/document/product/436/13324)
        String key = StringUtil.getCommonCode(2)+".jpg";
        File localFile = null;
        try {
            localFile = multipartFileToFile(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia)
        putObjectRequest.setStorageClass(StorageClass.Standard_IA);
        try {
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
            Date expiration = new Date(new Date().getTime() + 5 * 60 * 10000);
            URL url = cosclient.generatePresignedUrl(bucketName, key, expiration);
            System.out.println("图片在COS服务器上的url:"+url);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();
            return AppResponse.success("图片上传成功",url.toString());
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }

        // 关闭客户端
        cosclient.shutdown();
        return AppResponse.notFound("图片上传失败");
    }

    /**
     * 转file
     * @param file
     * @return
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }

    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }
}