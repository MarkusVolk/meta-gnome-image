do_install:append() {
	sed -i "s|Terminal=true|Terminal=false|" ${D}${datadir}/applications/htop.desktop
	sed -i "s|Exec=htop|Exec=blackbox -c htop|" ${D}${datadir}/applications/htop.desktop
}
