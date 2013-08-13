package com.griddynamics.monitor;

import com.gigaspaces.cluster.replication.async.mirror.MirrorStatistics;
import org.openspaces.admin.Admin;
import org.openspaces.admin.AdminFactory;
import org.openspaces.admin.space.Space;
import org.openspaces.admin.space.SpaceInstance;

import java.util.concurrent.TimeUnit;

public class MirrorMonitor {
    Admin admin;

    public MirrorMonitor() {
        this.admin = new AdminFactory().addGroup("MirrorApp").createAdmin();
        admin.setStatisticsInterval(5, TimeUnit.SECONDS);
        admin.setStatisticsHistorySize(1000);
    }

    public String getStatus() {
        StringBuffer stringBuffer = new StringBuffer();
        for (Space space : admin.getSpaces()) {
         for (SpaceInstance spaceInstance : space) {
                MirrorStatistics mirrorStat = spaceInstance.getStatistics().getMirrorStatistics();
                if (mirrorStat != null) {
                    stringBuffer.append(String.format("total operation count: %d | ",
                            mirrorStat.getOperationCount()));
                    stringBuffer.append(String.format("successful operation count: %d | ",
                            mirrorStat.getSuccessfulOperationCount()));
                    stringBuffer.append(String.format("failed operation count:%d",
                            mirrorStat.getFailedOperationCount()));
                }
            }
        }
        return stringBuffer.toString();
    }
}
