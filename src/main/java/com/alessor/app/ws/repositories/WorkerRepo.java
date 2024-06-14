package com.alessor.app.ws.repositories;

import com.alessor.app.ws.io.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepo extends JpaRepository<Worker, Integer> {
}
