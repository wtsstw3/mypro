package simple;

import java.security.CodeSigner;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;

/**
 * Created by Black on 03.12.2018.
 */
public class SandBox {
    private static final ProtectionDomain MINIMAL_PERMISSION_DOMAIN = createMinimalPermissionDomain();

    public static void main(String[] args){
        SandBox sandBox = new SandBox();
        CodeSource codeSource = sandBox.getClass().getProtectionDomain().getCodeSource();

    }

    private static ProtectionDomain createMinimalPermissionDomain() {
        // Generated classes need to have at least the permission to access Nashorn runtime and runtime.linker packages.
        final Permissions permissions = new Permissions();
        permissions.add(new RuntimePermission("accessClassInPackage.jdk.nashorn.internal.objects"));
        permissions.add(new RuntimePermission("accessClassInPackage.jdk.nashorn.internal.runtime"));
        permissions.add(new RuntimePermission("accessClassInPackage.jdk.nashorn.internal.runtime.linker"));
        return new ProtectionDomain(new CodeSource(null, (CodeSigner[])null), permissions);
    }
}
