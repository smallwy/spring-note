/*
package com.timer;


import com.gameart.network.session.GameSession;
import com.gameart.threads.ICommand;
import com.gameart.utils.lang.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

*/
/***
 *
 * @author JackLei
 * @Date 2018年5月25日 下午4:52:42
 *//*

public class PacketExecutor extends UniversalSpokesmanOfGod {
	private static final Logger LOGGER = LoggerFactory.getLogger(PacketExecutor.class);
	private static Boolean PLACE_HOLDER = Boolean.valueOf(true);

	private String name;

	public PacketExecutor(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	protected long calSleepMillis(long cost) {
		return 30;
	}

	@Override
	protected int getWarnCost() {
		return 0;
	}

	@Override
	public void execute(boolean running) {

		ICommand command = commands.poll();
		while (command != null) {
			command.execute();
			command = commands.poll();
		}

		for (GameSession session : sessions.keySet()) {
			try {
				session.tick();
				session.flush();
			} catch (Exception e) {
				LOGGER.error(Strings.format("Error occure when tick session ID=%0, Account=%1", session.getID(),
						session.getPlatformId()), e);
			}
		}

	}

	public void addAction(ICommand command) {
		commands.add(command);
	}

	public void addSession(GameSession session) {
		sessions.put(session, PLACE_HOLDER);
	}

	public void removeSession(GameSession session) {
		sessions.remove(session);
	}
}
*/
