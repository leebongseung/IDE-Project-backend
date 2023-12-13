package goorm.dbjj.ide.domain.outputlog;

import goorm.dbjj.ide.domain.outputlog.dto.request.LogEntry;

/**
 * 사용자가 수행한 결과를 제공하는 서비스입니다.
 * 결과는 lambda로부터 받아서 웹소켓으로 전송됩니다.
 */
public interface OutputSendingService {

    /**
     * 사용자에게 수행한 결과를 제공합니다.
     * @param logEntry
     */
    void sendTo(LogEntry logEntry);
}
