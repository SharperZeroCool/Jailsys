package br.com.jailsys.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public final class CriptografiaUtil {
    public static String criptografar(String senha) {
        return Hashing.md5().hashString(senha, Charsets.UTF_8).toString();
    }
}
