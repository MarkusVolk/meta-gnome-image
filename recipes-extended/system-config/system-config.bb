LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit main-user

SRC_URI = " \
	file://bashrc \
	file://bash_profile \
	file://flathub.sh \
"

RRECOMMENDS:${PN} = " \
	netcat \
"	
	
do_install() {
	install -d ${D}${MAIN_USER_HOMEDIR}/.kodi/userdata/addon_data/pvr.iptvsimple
	install -m 0755 ${WORKDIR}/flathub.sh ${D}${MAIN_USER_HOMEDIR}/flathub.sh
	install -m 0644 ${WORKDIR}/bash_profile ${D}${MAIN_USER_HOMEDIR}/.bash_profile
	install -m 0644 ${WORKDIR}/bashrc ${D}${MAIN_USER_HOMEDIR}/.bashrc
        chown ${MAIN_USER_NAME}:${MAIN_USER_NAME} -R ${D}${MAIN_USER_HOMEDIR}
}

FILES:${PN} = "${MAIN_USER_HOMEDIR}"

INSANE_SKIP:${PN} = "host-user-contaminated"

