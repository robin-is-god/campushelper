package edu.cuit.robin.campushelper.service.Impl;

import edu.cuit.robin.campushelper.dao.InfoMessageDao;
import edu.cuit.robin.campushelper.model.InfoMessage;
import edu.cuit.robin.campushelper.service.InfoMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ Author      : robin.
 * @ Date        : Created in 15:33 2019/5/14
 * @ Description : TODO
 */

@Service
public class InfoMessageServiceImpl implements InfoMessageService {
    @Autowired
    private InfoMessageDao infoMessageDao;

    @Override
    public boolean insertInfoMessage(InfoMessage infoMessage) {
        if(infoMessage != null){
            if(infoMessage.getContent() != null && infoMessage.getContent() !="") {
                try {
                    int rs = infoMessageDao.insertInfoMessage(infoMessage);
                    if (rs > 0) {
                        return true;
                    } else {
                        throw new RuntimeException("插入失败！");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("插入失败：" + e.getMessage());
                }
            } else {
                throw new RuntimeException("插入内容为空。");
            }
        } else {
            throw new RuntimeException("插入失败，内容为空。");
        }
    }

    @Override
    public List<Map<String, Object>> queryInfoMessage(InfoMessage infoMessage) {
        return infoMessageDao.queryInfoMessage(infoMessage);
    }

    @Override
    public boolean deleteInfoByPid(Integer pId) {
        if(pId != null){
            int rs = infoMessageDao.deleteInfoByPid(pId);
            if(rs >= 0)
                return true;
            else {
                throw new RuntimeException("删除数据失败");
            }
        } else {
            throw new RuntimeException("删除数据编号pId为" + pId  +"为空");
        }
    }

    @Override
    public boolean deleteInfoByAid(Integer aId) {
        if(aId != null){
            int rs = infoMessageDao.deleteInfoByPid(aId);
            if(rs >= 0)
                return true;
            else {
                throw new RuntimeException("删除数据失败");
            }
        } else {
            throw new RuntimeException("删除数据编号aId为" + aId  +"为空");
        }
    }

    @Override
    public boolean deleteInfoByCid(Integer cId) {
        if(cId != null){
            int rs = infoMessageDao.deleteInfoByPid(cId);
            if(rs >= 0)
                return true;
            else {
                throw new RuntimeException("删除数据失败");
            }
        } else {
            throw new RuntimeException("删除数据编号cId为" + cId  +"为空");
        }
    }
}
