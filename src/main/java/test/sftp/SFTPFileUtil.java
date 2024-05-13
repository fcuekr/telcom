package test.sftp;

import com.jcraft.jsch.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class SFTPFileUtil {
    public static void main(String[] args) {
        upload("prs3000","prs3000","10.3.30.64",22,"/home/prs3000/java_deploy/flanker/report","C:\\Users\\陈毅宸\\Desktop\\222.xls");
    }

    public static void upload(String username,String password,String host,int port,String filePath,String uploadFile) {
        Session sshSession = null;
        ChannelSftp sftp = null;
        try {
            //创建链接
            JSch jsch = new JSch();
            jsch.getSession(username, host, port);
            sshSession = jsch.getSession(username, host, port);
            sshSession.setPassword(password);
            sshSession.setTimeout(100000);
            Properties sshConfig = new Properties();
            sshConfig.put("StrictHostKeyChecking", "no");
            sshSession.setConfig(sshConfig);
            sshSession.connect();
            Channel channel = sshSession.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            //发送文件、
            sftp.cd(filePath);
            SftpATTRS stat = sftp.stat(sftp.pwd());
            String[] extended = stat.getExtended();
            for (String s : extended) {
                System.out.println(s);
            }
            /*System.out.println("-------上传文件-------:"+uploadFile);
            File file = new File(uploadFile);
            sftp.put(new FileInputStream(file), file.getName());
            System.out.println("-------上传完成-------:"+filePath);*/
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sftp.isConnected()) {
                sshSession.disconnect();
                sftp.disconnect();
            }
        }
    }
}
