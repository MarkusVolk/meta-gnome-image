PACKAGECONFIG:append:class-target = " cloudproviders cups iso-codes tracker colord ${@bb.utils.contains('LICENSE_FLAGS_ACCEPTED', 'commercial', 'ffmpeg', '', d)}"
