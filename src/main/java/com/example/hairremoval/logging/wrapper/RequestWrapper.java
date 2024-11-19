package com.example.hairremoval.logging.wrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class RequestWrapper extends HttpServletRequestWrapper {

    private byte[] mbodyBuffer;


    public RequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        InputStream in = request.getInputStream();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int bytesRead = 1;
        while ((bytesRead = in.read(buffer))> 0){
            baos.write(buffer,0,bytesRead);
        }
        mbodyBuffer = baos.toByteArray();
    }

    @Override
    public BufferedReader getReader()throws IOException{
        return new BufferedReader(new InputStreamReader(this.getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() {
        ByteArrayInputStream in = new ByteArrayInputStream(mbodyBuffer);
        return new BufferedServletInputStream(in);
    }

    public String getRequestBody(){
        return new String(mbodyBuffer, Charset.forName("UTF-8"));
    }

    private static final class BufferedServletInputStream extends ServletInputStream {

        private ByteArrayInputStream bais;

        public BufferedServletInputStream(ByteArrayInputStream bais) {
            this.bais = bais;
        }

        @Override
        public int available() {
            return this.bais.available();
        }

        @Override
        public int read() {
            return this.bais.read();
        }

        @Override
        public int read(byte[] b, int off, int len) {
            return this.bais.read( b, off, len );
        }

        @Override
        public boolean isFinished() {
            return available() == 0;
        }

        @Override
        public boolean isReady() {
            return true;
        }

        @Override
        public void setReadListener(ReadListener listener) {
        }
    }
}
